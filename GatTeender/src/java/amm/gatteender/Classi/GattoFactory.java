/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.gatteender.Classi;

import java.util.ArrayList;

/**
 *
 * @author Tutor_IUM
 */
public class GattoFactory {

    //Pattern Design Singleton
    private static GattoFactory singleton;

    public static GattoFactory getInstance() {
        if (singleton == null) {
            singleton = new GattoFactory();
        }
        return singleton;
    }

    private ArrayList<Gatto> listaGatti = new ArrayList<Gatto>();

    private GattoFactory() {
        //Creazione utenti

        //Djanni
        Gatto gatto1 = new Gatto();
        gatto1.setId(0);
        gatto1.setNome("Djanni");
        gatto1.setEmail("djannigatto@gmail.com");
        gatto1.setRazza("Incrocio");
        gatto1.setPassword("123");
        gatto1.setUrlFotoProfilo("img/djanniprofilo.jpg");

        //HeavyBreathing
        Gatto gatto2 = new Gatto();
        gatto2.setId(1);
        gatto2.setNome("HeavyBreathing");
        gatto2.setEmail("cholansia@gmail.com");
        gatto2.setRazza("British Shorthair");
        gatto2.setPassword("123");
        gatto2.setUrlFotoProfilo("img/user1.gif");

        //GymWorkOut
        Gatto gatto3 = new Gatto();
        gatto3.setId(2);
        gatto3.setNome("GymWorkOut");
        gatto3.setEmail("doIt@gmail.com");
        gatto3.setRazza("Gatto Sacro di Birmania");
        gatto3.setPassword("123");
        gatto3.setUrlFotoProfilo("img/user2.jpg");

        //ChaoPovery
        Gatto gatto4 = new Gatto();
        gatto4.setId(3);
        gatto4.setNome("ChaoPovery");
        gatto4.setEmail("r1tchb1tch@gmail.com");
        gatto4.setRazza("Ocicat");
        gatto4.setPassword("123");
        gatto4.setUrlFotoProfilo("img/user3.jpg");

        listaGatti.add(gatto1);
        listaGatti.add(gatto2);
        listaGatti.add(gatto3);
        listaGatti.add(gatto4);
    }

    public Gatto getGattoById(int id) {
        for (Gatto gatto : this.listaGatti) {
            if (gatto.getId() == id) {
                return gatto;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(Gatto gatto : this.listaGatti){
            if(gatto.getNome().equals(user) && gatto.getPassword().equals(password)){
                return gatto.getId();
            }
        }
        return -1;
    }
}
