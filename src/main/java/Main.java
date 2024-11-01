
import com.mycompany.reservedroom.controllers.CustomerController;
import com.mycompany.reservedroom.controllers.ReservationController;
import com.mycompany.reservedroom.views.ReservedRoomGUI;
import com.mycompany.reservedroom.controllers.RoomController;

/**
 *
 * @author thana
 */
public class Main {
    public static void main(String[] args) {
        ReservedRoomGUI mainGUI = new ReservedRoomGUI(new RoomController(), new CustomerController(), new ReservationController());
        mainGUI.setVisible(true);
    }
}
