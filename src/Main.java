import java.util.Random;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        room.start();
    }
}

class Doctor extends Thread {
    @Override
    public void run() {

    }
}

class Visitor extends Thread {
    @Override
    public void run() {

    }
}

class Room extends Thread {
    private static int Doctor = 0;
    private static int Visitor = 0;
    private static int countForNumber = 1;
    private static int countForVisitor = 0;

    @Override
    public void run() {

        do {
            Random random = new Random();


            System.out.println("Room №" + countForNumber);


            if (random.nextInt(5) == 1) {
                if (Visitor == 0 && Doctor == 0) {
                    synchronized (this){
                    Doctor doctor = new Doctor();
                    doctor.start();
                    Doctor++;
                    System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Doctor--;
                    System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);
                }
            }}

            if (random.nextBoolean()) {
                if (Visitor <= 4 && Doctor == 0 || Visitor >= 0) {
                    Visitor visitor = new Visitor();
                    visitor.start();
                    Visitor++;
                    System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);

                    if (countForVisitor==2 && Visitor>=2) {
                        Visitor =0;
                        System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);
                        countForVisitor=1;

                    }

                    if (Visitor == 4) {
                        Visitor = Visitor - 2;
                        System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);
                        countForVisitor=2;

                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Doctor: " + Doctor + " | Visitor: " + Visitor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (countForNumber == 10) {
                countForNumber = 1;
            } else {
                countForNumber++;
            }
        } while (true);
    }
}