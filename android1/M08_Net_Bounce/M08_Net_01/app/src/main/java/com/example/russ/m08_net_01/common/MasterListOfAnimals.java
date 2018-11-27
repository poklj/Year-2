package com.example.russ.m08_net_01.common;

//import android.graphics.Color;;
import com.example.russ.m08_net_01.common.NetworkAnimal.Animal;

import java.util.ArrayList;


/**
 * @author Russ
 *         <p>
 *         Keep the Master List from becoming corrupted
 */
public class MasterListOfAnimals {

    ///Data Structure with Animals
    private ArrayList<NetworkAnimal> master_list = new ArrayList<NetworkAnimal>();
    private int mater_list_count = 0;


    public NetworkAnimal getAnimal(int index) {
        return this.master_list.get(index);
    }

    public void setAnimal(NetworkAnimal a) {
        // get animal # indexed by this animal
        NetworkAnimal animal_to_change;
        animal_to_change = this.master_list.get(a.getAnimal_number());
        animal_to_change.updateAllButIndex(a);  // set new values
    }

    // <RS> changed Color to int
    public int newAnimal(Animal a, int pos_x, int pos_y, int vel_x, int vel_y, int c, String s) {
        // get animal # indexed by this animal

        NetColor nc = NetColor.WHITE;
        NetworkAnimal new_animal = new NetworkAnimal(a, pos_x, pos_y, vel_x, vel_y, nc, s);
        new_animal.updateIndex(mater_list_count++);
        master_list.add(new_animal);
        return mater_list_count;
    }


}
