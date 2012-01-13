#pragma version(1)
#pragma rs java_package_name(com.example);
 
#include "rs_graphics.rsh"
 
 // Background color is a 4 part float
float4 bgColor;
 
void init() {
    // Initialize background color to black
    bgColor = (float4) { 0.0f, 0.0f, 0.0f, 1.0f };
}
 
int root() {
    // Set background color
    rsgClearColor(bgColor.x, bgColor.y, bgColor.z, bgColor.w);
    
    // Set font color
    rsgFontColor(1.0f, 1.0f, 1.0f, 1.0f);
    
    // Draw text at position 50, 50
    rsgDrawText("Hello World!", 50.0f, 50.0f);
    
    // Run every 20 milliseconds
    return 20;
}
