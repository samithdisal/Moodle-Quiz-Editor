/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.floss.moe.mqe.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.floss.moe.mqe.resource.font.RL;

/**
 *
 * @author sam
 */
public class SinhalaFontResource {
    private static Font BHASHITA_TTF;
    private static Font MALITHI_TTF;
    
    public static Font getBhashita(int size) {
        if(BHASHITA_TTF==null) {
            try {
                BHASHITA_TTF = Font.createFont(Font.TRUETYPE_FONT, RL.class.getResourceAsStream("LBhashitaComplex.ttf"));
                
            } catch (FontFormatException ex) {
                Logger.getLogger(SinhalaFontResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SinhalaFontResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return BHASHITA_TTF.deriveFont(Font.BOLD, size);
    }
    
    public static Font getMalithi(int size) {
        if(MALITHI_TTF==null) {
            try {
                MALITHI_TTF = Font.createFont(Font.TRUETYPE_FONT, RL.class.getResourceAsStream("FM-MalithiUW46.ttf"));
                
            } catch (FontFormatException ex) {
                Logger.getLogger(SinhalaFontResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SinhalaFontResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return MALITHI_TTF.deriveFont(Font.PLAIN, size);
    }
}
