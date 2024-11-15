/*  
Name: Tsugoii
Date: 26/09/2021
Description: Main
*/

import java.io.*;

public class InvalidTreeSyntax extends Exception {
    // user defined exceptions
    public InvalidTreeSyntax (String error) {
        super("Error Thrown: " + error);
    }
}