/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BTRobot.debugger.modules.control;

import edu.wpi.first.wpilibj.Joystick;
//import java.util.ArrayList;
/**
 *
 * @author Scott Fisk
 * @version 1.0
 */
public class controllerTest 
{
    Joystick controller;
    Joystick[] controllerArr;
    //ArrayList<Joystick> controllerList = new ArrayList<Joystick>();
    public controllerTest() 
    {
        int[] count = new int[5];
        count[0] = 0;
        for(int x = 0; x < 4 ; x++)
        {
            controller = new Joystick(x+1);
            if(isThereController())
            {
                count[0]++;
                count[x+1] = x;
            }
        }
        controllerArr = new Joystick[count[0]];
        for(int x = 0 ; x < count[0] ; x++)
        {
            controllerArr[x] = new Joystick(count[x+1]);
        }
        
    }
    public boolean isThereController()
    {
        boolean isThere = false; //Find better way to check for controller
        long counter = 0;
        while(isThere == false && counter<10000)
        {
           for(int x = 1 ; x < 6 ; x++)
           {
                if(0 != controller.getRawAxis(x))
                {
                    isThere = true;
                }
           }
           counter++;
        }
        return isThere;
    }
}


