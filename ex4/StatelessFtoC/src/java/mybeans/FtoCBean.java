/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import javax.ejb.Stateless;

/**
 *
 * @author Pondj
 */
@Stateless
public class FtoCBean implements FtoCBeanRemote {

    @Override
    public double FtoC(double far) {
        return (5.0 / 9.0) * (far - 32);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
