 ArrayList<Rectangle> sections = new ArrayList<Rectangle>();
color bgColor = color(31, 0, 48);

// RGB colors
color[] sunColors = {
  color(212, 202, 11), 
  color(214, 198, 30), 
  color(211, 170, 26), 
  color(216, 157, 51), 
  color(217, 124, 64), 
  color(213, 104, 81), 
  color(212, 51, 98), 
  color(215, 29, 121), 
  color(217, 11, 139), 
  color(217, 0, 151)
};
float y;
float h;
float x;
float w;
float y2;
//float h2;
float y3;
//float h3;
void setup() {
y=(width/2);
h=25;
x = 300 - 150;
w = 2 * 150;
Rectangle r1 = new Rectangle(x,y,w,h);

sections.add(r1);
y2=(width/3);
Rectangle r2 = new Rectangle(x,y2,w,h);
sections.add(r2);
///h2=20;
y3 =(width/4);
Rectangle r3 = new Rectangle(x,y3,w,h);
sections.add(r3);
//h3 = 30;
  // 1. Set the size of your sketch
  size(600,400);
}


void draw() {
  // 2. Draw the bgColor background color
background(bgColor);
  /*
   * PART 1: Drawing the sun
   */
   fill(sunColors[0]);
ellipse(300,175,300,300);

noStroke();
  // Draw an ellipse for the sun in the center of the window
  // Use fill(sunColors[0]) to make it yellow
  // Use noStroke() to remove the black outline

  // Do you see a yellow sun like in the 1st image?
  // If not, fix your code before proceeding.

  /*
   * PART 2: Drawing a color gradient on the sun
   *
   * This will make the sun have gradually different colors from the 
   * top to bottom
   */

  // Call the loadPixels() method to put all the pixel colors into
  // the pixels[] array
  // https://processing.org/reference/loadPixels_.html
loadPixels();
  // Loop through all the pixels in your window.
  // By default, a pixel is a 1x1 colored square, so if the window width is 600 
  // and the height is 400 (600x400), then there are 600 * 400 = 240,000 pixels 
  for(int i = 0; i<pixels.length;i++){
    if(pixels[i]==sunColors[0]){
      int y = i / width;
float step = map(y, 25, 325, 0, 1);
 color colorSafe = interpolateColor(sunColors, step);
 pixels[i] = colorSafe;
    }

  }
    updatePixels();
    
    

    // We want to change the color of our sun so use an if statement
    // to check if the pixel is the color of the yellow circle. 

      // If it's the same color we need to map the pixel to a
      // color in our sunColors[] array (see 2nd gradient image)

      // The top of the sun is yellow (sunColors[0]) and the bottom
      // of the sun is red (sunColors[sunColors.length - 1]

      // In order to get the right color, the y value from the top of
      // the sun to the bottom has to be mapped to a range from 0 to 1.
      // Use the map() function to do that:
      // int y = i / width;
      // float step = map(y, sunTopY, sunBottomY, 0, 1);

      // Call interpolateColor(sunColors, step) and save the color
      // variable that's returned

      // Set pixels[i] to the returned color 


  // Call updatePixels() after your loop through all the pixels to
  // update the pixel colors
  // https://processing.org/reference/updatePixels_.html

  /*
   * PART 3: Drawing the missing sections at the bottom of the sun
   *
   * The missing parts of the sun are created by drawing rectangles
   * over the sun with the same color as the background.
   */

  // Set the fill color to the background color
for(int i = 0; i<sections.size();i++){
  sections.get(i).draw();
  sections.get(i).update();
}
  // To draw each rectangle we need to find its x, y, width, height
  // *The y position can be any value within the sun:
 // float y = (width / 2);
  // *The height can be any value you choose:
   //  float h = 20;
  // *The x position can be the center of the sun's x position minus the radius:
    // float x = 300 - 150;
  // * The width can be 2 times the radius
    // float w = 2 * 150;

//rect(x,y2,w,h2);
//rect(x,y3,w,h3);
  // Do you see a section missing from the sun like in the 3rd image?


  /*
   * PART 4: Moving the missing sun sections
   *
   * To move a section upwards each rectangle's y value needs to decrease.
   * To make the section get smaller, its height needs to also decrease.
   */

  // Decrease the y variable of the rectangular section created in PART 3.
  // If there isn't a variable, declare a float variable OUTSIDE of the
  // draw function AND initialize it in the setup() function.

//y2--;
////y3--;
  // Do you see the rectangle moving upwards?

  // Pick a y positon to be the location when the sections stop moving up.
  // If the rectangle's y positon is above this, move the rectangle's
  // y position back to the bottom of the sun.

//if(y2<50){
//  y2=300;
//}
//if(y3<20){
//  y3=270;
//}
  // Does the rectangle move back to the bottom?

  // Decrease the the height of the rectangle as it moves upwards.
  // Similar to the y positon, a float variable for the height needs to be
  // created if it doesn't already exist.

//h2=h2-0.08;
//h3=h3-0.06;
  // Adjust the amount to decrease so that it disappears close to the top.

  // Add code to reset the height of the rectangle when it moves back to
  // the bottom of the sun.

//  if(y2==300){
///    h2=20;
//  }
//  if(y3==315){
//    h3=15;
//  }

  /*
   * PART 5: Managing the missing sun sections
   *
   * Using a list to manage moving multiple missing sun sections 
   */

  // Figure out how to create the other missing sun sections using the
  // code you wrote for the 1 missing sun section.
  // *HINT* You can use the Rectangle class defined below to create
  //        a list of Rectangles.




  /*
   * PART 6: Adding extras
   *
   * If you want to make your retro sun look more unique, try adding
   * reflections and stars.
   * See the Retro Sun webpage on the League level 3 website
   * for example code and classes.
   */
//}

// Placed here so it can be used by all classes
// Variable step should be between 0 and 1, inclusive
}
color interpolateColor(color[] arr, float step) {
  int sz = arr.length;

  if (sz == 1 || step <= 0.0) {
    return arr[0];
  } else if (step >= 1.0) {
    return arr[sz - 1];
  }

  float scl = step * (sz - 1);
  int i = int(scl);

  return lerpColor(arr[i], arr[i + 1], scl - i);
}

// Feel free to use this class to create a list of missing
// sections in the sun, for example:
// ArrayList<Rectangle> sections = new ArrayList<Rectangle>();
class Rectangle {
  float x, y, w, h;

  Rectangle(float x, float y, float w, float h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
  void draw(){
    fill(bgColor);
    rect(x,y,w,h);
  }
  void update(){
   y--;
   if(y<80){
  y=330;
}
h=h-0.1;
  if(y==330){
    h=25;
  }
  }
}
