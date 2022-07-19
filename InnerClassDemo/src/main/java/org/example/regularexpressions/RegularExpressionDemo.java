package org.example.regularexpressions;

/*
+Metacharacters in regex --> has own special meaning
+quantifiers
    . --> match with any character
    * --> 0 or more
    + --> 1 or more
    ? --> 0 or 1
    {2} --> exact occurence
    {2,4} --> min limit and max limit, inclusive

+character classes [] --> group of characters within a pair of square brackets--> [ ]
+prebuilt character classes:
    regex-->pattern on api docs

+pattern groups () --> combine multiple characters as a single unit

+search operation using pattern instead of match
+perform search and replace

+lookahead and lookbehind
    Positive lookahead ?=
    Positive lookbehind ?<=
    negative lookahead ?!
    negative lookbehind ?<!
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {

    /*
    dd-MM-yyyy
    dd should be between 01 and 31 including 31
    MM should be between 01 and 12 indluding 12
    yyyy should be between 1900 and 2099
     */

    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //match this pattern at front and back
        //Pattern patty = Pattern.compile("0[1-9] | 1[0-9] | 2[0-9] | 3[0-1]-10-2024");

        Pattern patty = Pattern.compile("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}");
        Matcher matchy = patty.matcher("30-10-2024");

        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
}

//Exact Match Regex Intro Example
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //EXACT MATCH
        Pattern patty = Pattern.compile("deepan");
        Matcher matchy = patty.matcher("deepan");
        System.out.println(matchy.matches());
    }

    --CONSOLE--
    true
 */

//Two . metacharacters
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //the two periods refer to any character
        Pattern patty = Pattern.compile("d..pan");
        Matcher matchy = patty.matcher("deopan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    true
 */

//Two \ and two. to cancel metaChars
/*
  public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //the two periods refer to any character, two slashes cancel the meaning of metachars
        Pattern patty = Pattern.compile("d\\..pan");
        Matcher matchy = patty.matcher("d..pan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    true
 */

//Quantifier *
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        Pattern patty = Pattern.compile("d.*pan");
        Matcher matchy = patty.matcher("ddsf345&pan");
        System.out.println(matchy.matches());
    }
 */

//Quantifier .{}
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        Pattern patty = Pattern.compile("d.{2,4}pan");
        Matcher matchy = patty.matcher("d5435pan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    true
 */

//Character Class []
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        Pattern patty = Pattern.compile("d[e]{2,4}pan");
        Matcher matchy = patty.matcher("deeeepan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    true

    -------------------------------------------------
        public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        Pattern patty = Pattern.compile("d[e34]{2,4}pan");
        Matcher matchy = patty.matcher("d4e3epan");
        System.out.println(matchy.matches());
    }
    --CONSOLE-
    true
 */

//Character Class [^]
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        //carrot means you cannot have these specific chars
        Pattern patty = Pattern.compile("d[^e2jy34]{2,4}pan");
        Matcher matchy = patty.matcher("d4j3epan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    false
 */

//Character class [] with only numerical values (range)
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //[0-9] refers to range, 0123456789
        Pattern patty = Pattern.compile("d[0-9]{2,4}pan");
        Matcher matchy = patty.matcher("dxxpan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    false
 */

//[0-9a-zA-Z] multi range
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //.* refers to 0 or more between d and p
        //Pattern patty = Pattern.compile("d*pan"); means it can have any number of d's
        Pattern patty = Pattern.compile("d[0-9a-zA-Z]{2,4}pan");
        Matcher matchy = patty.matcher("dxxpan");
        System.out.println(matchy.matches());
    }
 */

//predefined character classes example
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //first backslash takes away metacharacteristic, and \d means any numerical
        Pattern patty = Pattern.compile("d\\d{2,4}pan");
        Matcher matchy = patty.matcher("dxxpan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    false
        public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //first backslash takes away metacharacteristic, and \d means any numerical
        Pattern patty = Pattern.compile("d\\D{2,4}pan");
        Matcher matchy = patty.matcher("dxxpan");
        System.out.println(matchy.matches());
    }
    --CONSOLE--
    true (changed from little d to big D)
 */

//pattern groups (de){5}
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //the 5 applies only to immediate left, e, not d and e
        //adding (de) in paranthes makes them a unit, 5 'de'
        Pattern patty = Pattern.compile("(de){5}");
        Matcher matchy = patty.matcher("dedededede");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
    1
 */

//using or operator
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //logical or separates is into one part was into another part
        Pattern patty = Pattern.compile("is|was|or");
        Matcher matchy = patty.matcher("was");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */

//or operator and patter
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //logical or separates is into one part was into another part
        Pattern patty = Pattern.compile("i(s|w)as|or");
        //can have or
        //must end with as
        //must begin with i
        //inbetween i and as can have s or w
        Matcher matchy = patty.matcher("isas");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */

//post look ahead
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //deepan should be followed by -SR, . applies to -SR not n
        Pattern patty = Pattern.compile("Deepan(?=-SR).{3}");
        Matcher matchy = patty.matcher("Deepan-SR");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */

//positive lookbehind
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //matches where all deepan concludes with -SR
        Pattern patty = Pattern.compile("Deepan.{3}(?<=-SR)");
        Matcher matchy = patty.matcher("Deepan-SR");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */

//negative lookbehind
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //followed by any 3 chars not -SR
        Pattern patty = Pattern.compile("Deepan.{3}(?<!-SR)");
        Matcher matchy = patty.matcher("Deepan-SR");
        System.out.println(matchy.matches());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    false
 */

//search operation matchy.find()
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        Pattern patty = Pattern.compile("is");
        Matcher matchy = patty.matcher("My Cat is lovely");
        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
 */

//setting index region to search for pattern
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        Pattern patty = Pattern.compile("is");
        Matcher matchy = patty.matcher("My Cat is lovely");
        //set start and end indexes
        matchy.region(0,5);
        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    false, comes after 0,5 region
 */

//replaceall
/*
   public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        Pattern patty = Pattern.compile("is");
        Matcher matchy = patty.matcher("My Cat is lovely");
        //set start and end indexes
        matchy.region(0,13);
        System.out.println(matchy.replaceAll("IS!!"));
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    My Cat IS!! lovely
 */

//find pattern at beginning
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        Pattern patty = Pattern.compile("^is");
        Matcher matchy = patty.matcher("My Cat is lovely is is");
        //set start and end indexes
        matchy.region(0,13);
        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    false
 */

//find pattern at end
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        Pattern patty = Pattern.compile("is$");
        Matcher matchy = patty.matcher("My Cat is lovely is is");
        //set start and end indexes
        //matchy.region(0,13);
        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */

//exact match with carrot and dollar
/*
    public static void main(String[] args) {
        System.out.println("Regular Expressions Demo");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");

        //match this pattern at front and back
        Pattern patty = Pattern.compile("^(is)$");
        Matcher matchy = patty.matcher("is");

        System.out.println(matchy.find());
        System.out.println(matchy.groupCount());
    }
    --CONSOLE--
    true
 */