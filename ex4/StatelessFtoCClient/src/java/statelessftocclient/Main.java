/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessftocclient;
import java.util.Scanner;
import mybeans.FtoCBeanRemote;
/**
 *
 * @author Pondj
 */
public class Main {

    @javax.ejb.EJB
    private static FtoCBeanRemote ftoCBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter degree in Fahrenheit: ");
        double far = sc.nextDouble();
        System.out.printf("%.1f Fahrenheit = %.1f Celsius", far, ftoCBean.FtoC(far));       
    }  
}
