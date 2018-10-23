<html>
<body>
 
 
 This is example of textview animation which i am developing.
 
 <br>
  This is a simple example for my library which i am developing.<br> 

  
<image src = "/images/videotogif_2018.10.23_14.20.32.gif">
  
Above gif show typo effect
  
<h1> XML </h1>
<h2> Simple Example</h2>



<pre>
<code>	
&ltdevnitish.com.animatedtext.AnimatedTextView
android:layout_width="match_parent"
android:layout_height="wrap_content"
/&gt
</code>
</pre>

<h3> Not triggering animation on start</h3>

Property :  autoState = 'false'

<pre>
<code>	
&ltdevnitish.com.animatedtext.AnimatedTextView
android:layout_width="match_parent"
android:layout_height="wrap_content"
app:autoStart="false"
/&gt
</code>
</pre>

<h1>Java</h1>
Java Provides more flexibility and effects on the textview.<br>

<h1> Starting Animation In Java</h1>

<pre>
<code>
  animatedTextView.animateText();
  </code>
  </pre>
  
 Above Line start a simple typo animation. 
<br>

<image src = "/images/Gif2.gif">

If you have multiple lines and and want to show different delay and speed typo animation. You can do it with
overloaded animateText();

<h4> #1Function Signature</h4>
<pre>
<code>
    public void animateText(final ArrayList<String> allString,
                             final ArrayList<Integer> allSpeed)
</code>
</pre>

<h4> allString</h4>
This parameter store all the string which you want to show.

<h4> AllSpeed </h4> 
This parameter store the timedelay between two two alphabet

<h4> Usage</h4>

<pre>
<code>
 
        ArrayList<String> allString = new ArrayList<>();
//        allString.add("N");
        allString.add("Nitish");
        allString.add(" Prasad");
        allString.add("How are you.What are you doing.");
        allString.add("This is a simple Library");
        allString.add("To Show Typo Effect on the text view");
        allString.add("I will add more effect");
        allString.add("in the library with time.");


        ArrayList<Integer> allInteger = new ArrayList<>();
//        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        
        textView.animateText(allString,allInteger);
 
 </code>
 </pre>

<h4> #2Function Signature</h4>
<pre>
<code>
    public void animateText(final ArrayList<String> allString,
                             final ArrayList<Integer> allSpeed,
                             final ArrayList<Integer> allDelay)
</code>
</pre>

<h4> allDelay</h4>
If you want some pause between to string you can specify delay in this parameter.

<h4> Usage</h4>

<pre>
<code>
 
        ArrayList<String> allString = new ArrayList<>();
//        allString.add("N");
        allString.add("Nitish");
        allString.add(" Prasad");
        allString.add("How are you.What are you doing.");
        allString.add("This is a simple Library");
        allString.add("To Show Typo Effect on the text view");
        allString.add("I will add more effect");
        allString.add("in the library with time.");


        ArrayList<Integer> allInteger = new ArrayList<>();
//        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        
        ArrayList<Integer> allDelays = new ArrayList<>();
//        allDelays.add(1000);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(500);
        allDelays.add(10);
        allDelays.add(500);
        allDelays.add(10);
        
        textView.animateText(allString,allInteger,allDelays);
 
 </code>
 </pre>


<h4> #3Function Signature</h4>
<pre>
<code>
    public void animateText(final ArrayList<String> allString,
                             final ArrayList<Integer> allSpeed,
                             final ArrayList<Integer> allDelay,
                             final boolean overlap)
</code>
</pre>

<h4> overlap</h4>
If you want to show animation in which previous string is removed which writting new string , than you can use this function 
alternative.

<h4> Usage</h4>

<pre>
<code>
 
        ArrayList<String> allString = new ArrayList<>();
//        allString.add("N");
        allString.add("Nitish");
        allString.add(" Prasad");
        allString.add("How are you.What are you doing.");
        allString.add("This is a simple Library");
        allString.add("To Show Typo Effect on the text view");
        allString.add("I will add more effect");
        allString.add("in the library with time.");


        ArrayList<Integer> allInteger = new ArrayList<>();
//        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        
        ArrayList<Integer> allDelays = new ArrayList<>();
//        allDelays.add(1000);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(500);
        allDelays.add(10);
        allDelays.add(500);
        allDelays.add(10);
        
        textView.animateText(allString,allInteger,allDelays,true);
 
 </code>
 </pre>

</body>


</html>
