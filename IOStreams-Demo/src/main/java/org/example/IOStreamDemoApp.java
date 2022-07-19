package org.example;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;

public class IOStreamDemoApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Writing to new file");
        System.out.println("======================");

        File destination = new File("src/main/resources/output.text");
        String message = "Welcome to the Java FSD Training\n"; //\n gives new line
        FileOutputStream fout = new FileOutputStream(destination);

        ObjectOutputStream objOut = new ObjectOutputStream(fout);

        Movie movie = new Movie(132, "Good Film"); //must serialize movie by implementing serializable in class

        objOut.writeObject(movie);

        fout.close();
        objOut.close();

        //----------------------
        FileInputStream fis = new FileInputStream(destination); //reading from dest
        ObjectInputStream objIn = new ObjectInputStream(fis); //reading from fis

        Movie fromFile = (Movie)objIn.readObject(); //need to downcast
        //obj present in stream, returns as object which is parent of movie, must downcase to read

        System.out.println(fromFile);
        System.out.println((Movie)objIn.readObject());
        fis.close();
        objIn.close();

    }
}

//create the output stream for console
//Program-----------Standard IO (console) using S.in/S.out--------------
/*
//using console as destination for output string
//output stream for writing to console
//output store in var called out System.out.println("HI");

//OutputStream out = System.out; //storing static variable out in our own variable out, doesnt work
// standard input and output streams are already created though out.println();
//PrintStream out = System.out; //get output stream of console
//out.println("Stackroute");

//InputStream in = System.in;
//int value = in.read();
//System.out.println((char)value);//adding char casts value into character
*/


//Program-----------FileInput/FileOutput-------ByteInput
/*
        System.out.println("Reading from file");
        System.out.println("======================");

        File source = new File("src/main/resources/input.text");
        //FileInputStream only reads first two characters
        FileInputStream fis = new FileInputStream(source);

        System.out.println("Bytes available: " + fis.available()); //int value of number of bytes available in that file
        System.out.println(fis.markSupported()); //returns false, cant mark position in string, so we have to wrap stream with buffer
        while(fis.available() > 0){
            System.out.print((char)fis.read());//reading as byte, then casting
        }
        System.out.println("");
        System.out.println("Bytes available: " + fis.available());
        fis.close(); //closing stream is necessary so memory used by object is ready for garbage collection
*/
//Program-----Buffer------FileInput/FileOutput------ByteInput
/*
        System.out.println("Reading from file");
        System.out.println("======================");

        File source = new File("src/main/resources/input.text");
        //FileInputStream only reads first two characters
        FileInputStream fis = new FileInputStream(source);

        BufferedInputStream bis = new BufferedInputStream(fis);

        System.out.println("Bytes available: " +bis.available());
        System.out.println(bis.markSupported());

        //mark start of stream
        bis.mark(0); //marks how many bytes to recall ie 100 bytes in this case
        while(bis.available() > 0){
            System.out.print((char)bis.read());
        }

        bis.reset();//resets position so we can read bytes again vs 0 bytes to read without this

        System.out.println("");
        System.out.println("Bytes available: " +bis.available());

        //wont read again with put bis.reset()
        while(bis.available() > 0){
            System.out.print((char)bis.read());
        }

        fis.close();
        bis.close();

        //========COMMENTED OUT===================================================
//        System.out.println("Bytes available: " + fis.available()); //int value of number of bytes available in that file
//        System.out.println(fis.markSupported()); //returns false, cant mark position in string, so we have to wrap stream with buffer
//        while(fis.available() > 0){
//            System.out.print((char)fis.read());//reading as byte, then casting
//        }
//        System.out.println("");
//        System.out.println("Bytes available: " + fis.available());
//        fis.close(); //closing stream is necessary so memory used by object is ready for garbage collection

 */


//Program-----------FileInput----------CharacterStream
/*
        System.out.println("Reading from file");
        System.out.println("======================");

       File source = new File("src/main/resources/input.text");
       FileReader fr = new FileReader(source); //since it is char string, cannot get available bytes bc it handles 16, 24, 32 bit char
       //FileReader fr = new FileReader(source, Charset.forName("utf-8"));

        System.out.println(fr.markSupported());
        System.out.println(fr.getEncoding()); //utf8 is default, can specify as listed above

        int value;
        while((value = fr.read()) > -1){
            System.out.print((char)value);
        }

        fr.close();
 */
//Program-----------FileInput----------CharacterStream
/*

        System.out.println("Reading from file");
        System.out.println("======================");

       File source = new File("src/main/resources/input.text");
       FileReader fr = new FileReader(source); //since it is char string, cannot get available bytes bc it handles 16, 24, 32 bit char
       //FileReader fr = new FileReader(source, Charset.forName("utf-8"));

        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.markSupported());
        System.out.println(fr.getEncoding()); //utf8 is default, can specify as listed above

        int value;
        br.mark(30);//mark tells us how many char or bytes the buffer should recall
        //must be more specific for characterstream
        while((value = br.read()) > -1){
            System.out.print((char)value);
        }

        br.reset();//after reading 10 char psotion becomes invalid, but while loop reads more than 10

        System.out.println("");

        String rowOne = (br.readLine());//returns whole line as string
        System.out.println(rowOne);

        //System.out.println(br.readLine());//if no further lines, it will return null


        fr.close();
        br.close();
 */
//Program-----------FileInput (MULTI ROWS) ----------CharacterStream
/*
        System.out.println("Reading from file");
        System.out.println("======================");

       File source = new File("src/main/resources/input.text");
       FileReader fr = new FileReader(source); //since it is char string, cannot get available bytes bc it handles 16, 24, 32 bit char
       //FileReader fr = new FileReader(source, Charset.forName("utf-8"));

        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.markSupported());
        System.out.println(fr.getEncoding()); //utf8 is default, can specify as listed above

//        int value;
//        br.mark(30);//mark tells us how many char or bytes the buffer should recall
//        //must be more specific for characterstream
//        while((value = br.read()) > -1){
//            System.out.print((char)value);
//        }
//
//        br.reset();//after reading 10 char psotion becomes invalid, but while loop reads more than 10

        String row = "";
        while((row = br.readLine()) != null){
            System.out.println(row);
        }

        System.out.println("");

        String rowOne = (br.readLine());//returns whole line as string
        System.out.println(rowOne);

        //System.out.println(br.readLine());//if no further lines, it will return null


        fr.close();
        br.close();
 */

//FileWriter and BufferedWriter
/*
        System.out.println("Writing to new file");
        System.out.println("======================");

        File destination = new File("src/main/resources/output.text");
        String message = "Welcome to the Java FSD Training\n"; //\n gives new line

        FileWriter fileWriter = new FileWriter(destination);

        fileWriter.write(message);//dont need to convert to bytes, send string itself
        fileWriter.write(message);
        fileWriter.write(message);

        fileWriter.close();
 */
//FileOutPutStream and BufferedOutPutStream
/*
        System.out.println("Writing to new file");
        System.out.println("======================");

        File destination = new File("src/main/resources/output.text");

        FileOutputStream fout = new FileOutputStream(destination);

        String message = "Welcome to the Java FSD Training";
        fout.write(message.getBytes());//converting string into bytes and then writing to file

        fout.close();
 */

//Object Streams (converting object to corresponding bytes) -- Serialization
//Object Streams handle serialization and deserialization
/*
       System.out.println("Writing to new file");
        System.out.println("======================");

        File destination = new File("src/main/resources/output.text");
        String message = "Welcome to the Java FSD Training\n"; //\n gives new line
        FileOutputStream fout = new FileOutputStream(destination);

        ObjectOutputStream objOut = new ObjectOutputStream(fout);

        Movie movie = new Movie(132, "Good Film"); //must serialize movie by implementing serializable in class

        objOut.writeObject(movie);

        fout.close();
        objOut.close();

        //----------------------
        FileInputStream fis = new FileInputStream(destination); //reading from dest
        ObjectInputStream objIn = new ObjectInputStream(fis); //reading from fis

        Movie fromFile = (Movie)objIn.readObject(); //need to downcast
        //obj present in stream, returns as object which is parent of movie, must downcase to read

        System.out.println(fromFile);
        System.out.println((Movie)objIn.readObject());
        fis.close();
        objIn.close();
 */