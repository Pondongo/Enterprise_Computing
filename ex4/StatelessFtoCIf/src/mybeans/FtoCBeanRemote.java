/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import javax.ejb.Remote;

/**
 *
 * @author Pondj
 */
@Remote
public interface FtoCBeanRemote {

    double FtoC(double far);
    
}
