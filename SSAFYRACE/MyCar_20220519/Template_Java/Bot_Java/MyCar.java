import DrivingInterface.*;

public class MyCar {

    boolean is_accident = false;
    int accident_count = 0;
    int recovery_count = 0;
    boolean is_debug = false;
    static boolean enable_api_control = true; // true(Controlled by code) /false(Controlled by keyboard)

    public void control_driving(boolean a1, float a2, float a3, float a4, float a5, float a6, float a7, float a8,
                                float[] a9, float[] a10, float[] a11, float[] a12) {

        // ===========================================================
        // Don't remove this area. ===================================
        // ===========================================================
        DrivingInterface di = new DrivingInterface();
        DrivingInterface.CarStateValues sensing_info = di.get_car_state(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
        // ===========================================================

        if(is_debug) {
            System.out.println("=========================================================");
            System.out.println("[MyCar] to middle: " + sensing_info.to_middle);

            System.out.println("[MyCar] collided: " + sensing_info.collided);
            System.out.println("[MyCar] car speed: " + sensing_info.speed + "km/h");

            System.out.println("[MyCar] is moving forward: " + sensing_info.moving_forward);
            System.out.println("[MyCar] moving angle: " + sensing_info.moving_angle);
            System.out.println("[MyCar] lap_progress: " + sensing_info.lap_progress);

            StringBuilder forward_angles = new StringBuilder("[MyCar] track_forward_angles: ");
            for (Float track_forward_angle : sensing_info.track_forward_angles) {
                forward_angles.append(track_forward_angle).append(", ");
            }
            System.out.println(forward_angles);

            StringBuilder to_way_points = new StringBuilder("[MyCar] distance_to_way_points: ");
            for (Float distance_to_way_point : sensing_info.distance_to_way_points) {
                to_way_points.append(distance_to_way_point).append(", ");
            }
            System.out.println(to_way_points);

            StringBuilder forward_obstacles = new StringBuilder("[MyCar] track_forward_obstacles: ");
            for (DrivingInterface.ObstaclesInfo track_forward_obstacle : sensing_info.track_forward_obstacles) {
                forward_obstacles.append("{dist:").append(track_forward_obstacle.dist)
                        .append(", to_middle:").append(track_forward_obstacle.to_middle).append("}, ");
            }
            System.out.println(forward_obstacles);

            StringBuilder opponent_cars = new StringBuilder("[MyCar] opponent_cars_info: ");
            for (DrivingInterface.CarsInfo carsInfo : sensing_info.opponent_cars_info) {
                opponent_cars.append("{dist:").append(carsInfo.dist)
                        .append(", to_middle:").append(carsInfo.to_middle)
                        .append(", speed:").append(carsInfo.speed).append("km/h}, ");
            }
            System.out.println(opponent_cars);

            System.out.println("=========================================================");
        }

        // ===========================================================
        // Area for writing code about driving rule ==================
        // ===========================================================
        // Editing area starts from here
        //

        float set_brake = 0.0f;
        float set_throttle = 0.7f;

        int angle_num = (int) (sensing_info.speed / 45);
        float ref_angle = sensing_info.track_forward_angles.get(angle_num);
        float middle_add = (sensing_info.to_middle/70) * -1;

        float set_steering = (ref_angle - sensing_info.moving_angle)/(180 - sensing_info.speed);
        set_steering += middle_add;

        boolean [] left = new boolean[8];
        boolean [] right = new boolean[8];
        if(sensing_info.track_forward_obstacles.size() > 0){
            DrivingInterface.ObstaclesInfo fwd_obstacle = sensing_info.track_forward_obstacles.get(0);

//            for(int i=0; i<8; i++){
//                DrivingInterface.ObstaclesInfo ob = sensing_info.track_forward_obstacles.get(i);
//                if(ob.dist < 60 && ob.dist > 0 && Math.abs(ob.to_middle) <  8.0){
//                    if(ob.to_middle>0){
//
//                    }
//                }
//            }
//            if(fwd_obstacle.dist < 80 && fwd_obstacle.dist >= 30 && Math.abs(fwd_obstacle.to_middle) <  8.0){
//                float avoid_width = 2.7f;
//                float diff = fwd_obstacle.to_middle - sensing_info.to_middle;
//                if(Math.abs(diff) < avoid_width){
//                    if(diff <= 0) ref_angle = (float) (Math.abs(Math.atan((diff - avoid_width) / fwd_obstacle.dist) * 57.29579));
//                    else ref_angle = (float) (Math.abs(Math.atan((diff + avoid_width) / fwd_obstacle.dist) * 57.29579));
//                    middle_add = 0;
//                    set_steering = (ref_angle - sensing_info.moving_angle)/(180 - sensing_info.speed);
//                    set_steering += middle_add;
//                }
//            } else 
            	if (fwd_obstacle.dist < 40 && fwd_obstacle.dist > 0 && Math.abs(fwd_obstacle.to_middle) <  8.0){
                float avoid_width = 3.2f;
                set_throttle = 0.65f;
                float diff = fwd_obstacle.to_middle - sensing_info.to_middle;
                if(Math.abs(diff) < avoid_width){
                    if(diff <= 0) ref_angle = (float) (Math.abs(Math.atan((diff + avoid_width) / fwd_obstacle.dist) * 57.29579));
                    else ref_angle = (float) (Math.abs(Math.atan((avoid_width - diff) / fwd_obstacle.dist) * 57.29579));
                    middle_add = 0;
                    set_steering = (ref_angle - sensing_info.moving_angle)/(150 - sensing_info.speed);
                    set_steering += middle_add;
                }
            }
        }
        
        if(sensing_info.track_forward_angles.get(2)>25||sensing_info.track_forward_angles.get(2)<-25) {
        	set_brake=0.1f;
        }

        if(sensing_info.opponent_cars_info.size()>0){
            DrivingInterface.CarsInfo opp_car = sensing_info.opponent_cars_info.get(0);
            if(opp_car.dist < 20 && opp_car.dist > -5){
                float offset = (8 - Math.abs(opp_car.to_middle)) / 2;
                if(opp_car.to_middle > sensing_info.to_middle){
                    middle_add = ((sensing_info.to_middle + offset) / 70 ) * -1;
                } else {
                    middle_add = ((sensing_info.to_middle - offset) / 70 ) * -1;
                }
                set_steering += middle_add;
            }
        }

        boolean full_throttle = true;
        boolean emergency_brake = false;

        int road_range = (int) (sensing_info.speed / 30);
        for(int i=0; i<road_range; i++){
            float fwd_angle = Math.abs(sensing_info.track_forward_angles.get(i));
            if(fwd_angle > 50){
                full_throttle = false;
            }
            if(fwd_angle > 90){
                emergency_brake = true;
                break;
            }
        }

        if(!full_throttle){
            if(sensing_info.speed > 130){
                set_throttle = 0.5f;
            }

            if(sensing_info.speed>120){
                set_brake = 1;
            }
        }

        if(emergency_brake){
            if(set_steering > 0){
                set_steering += 0.3;
            }
            else {
                set_steering -= 0.3;
            }
        }

        if(sensing_info.lap_progress > 0.5 && !is_accident && (sensing_info.speed < 1.0 && sensing_info.speed > -1.0)){
            accident_count += 1;
        }

        if(accident_count > 6) is_accident = true;

        if(is_accident) {
            set_steering = 0.02f;
            set_brake = 0;
            set_throttle = -1;
            recovery_count += 1;
        }

        if(recovery_count > 20){
            is_accident = false;
            recovery_count = 0;
            accident_count = 0;
            set_steering = 0;
            set_brake = 0;
            set_throttle = 0;
        }

        // Moving straight forward
        car_controls.steering = set_steering;
        car_controls.throttle = set_throttle;
        car_controls.brake = set_brake;


        if(is_debug) {
            System.out.println("[MyCar] steering:"+car_controls.steering+
                                     ", throttle:"+car_controls.throttle+", brake:"+car_controls.brake);
        }

        //
        // Editing area ends
        // =======================================================
    }

    // ===========================================================
    // Don't remove below area. ==================================
    // ===========================================================
    public native int StartDriving(boolean enable_api_control);

    static MyCar car_controls;

    float throttle;
    float steering;
    float brake;

    static {
        System.loadLibrary("DrivingInterface/DrivingInterface");
    }

    public static void main(String[] args) {
        System.out.println("[MyCar] Start Bot! (JAVA)");

        car_controls = new MyCar();
        int return_code = car_controls.StartDriving(enable_api_control);

        System.out.println("[MyCar] End Bot! (JAVA), return_code = " + return_code);

        System.exit(return_code);
    }
    // ===========================================================
}
