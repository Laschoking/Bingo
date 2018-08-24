public class GarageDoor {
    private Motor motor;
    private DoorState currentState;

    public GarageDoor(){
        motor = new Motor();
        currentState = new Closed();
    }

    public void openDoor(){
        currentState.openDoor();
        motor.upwards();
    }

    public void stopper(){
        currentState.stopper();
        motor.stop();
    }

    public void closeDoor(){

        currentState.closeDoor();
        motor.downwards();
    }

    public Motor getMotor(){

        return motor;
    }

    private void setState(DoorState ds){
        currentState = ds;
    }

    public abstract class DoorState {
        public void openDoor(){
            throw new IllegalStateException();
        }
        public void closeDoor(){
            throw new IllegalStateException();
        }

        public void stopper(){
            throw new IllegalStateException();

        }
    }

    public class Closed extends DoorState {

        @Override
        public void openDoor() {
            currentState = new Opening();
        }
    }

    public class Opening extends DoorState {

        @Override
        public void closeDoor(){
            currentState = new Closing();
        }

        @Override
        public void stopper(){
            currentState = new Open();
        }
    }

    public class Open extends DoorState {
        @Override
        public void closeDoor(){
            currentState = new Closing();

        }
    }
    public class Closing extends DoorState {

        @Override
        public void openDoor(){
            currentState = new Opening();
        }

        @Override
        public void stopper(){
            currentState = new Closed();
        }
    }



}
