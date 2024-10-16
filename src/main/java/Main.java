
import com.mycompany.reservedroom.views.ReservedRoomGUI;
import com.mycompany.reservedroom.controllers.RoomController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thana
 */
public class Main {
    public static void main(String[] args) {
        ReservedRoomGUI mainGUI = new ReservedRoomGUI(new RoomController());
        mainGUI.setVisible(true);
    }
}
