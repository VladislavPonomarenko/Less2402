import java.util.Random;

/**
 * Created by wp-1-09 on 24.02.2017.
 */
public class Main {
    private static int Doctor = 0;
    private static int Visitor = 0;

    public static void main(String[] args) {

        for (int c = 0; c < 30; c++) {
            Random random = new Random();
            int number = random.nextInt(5);


            if (number == 1) {
                if (Visitor == 0 && Doctor == 0) {
                    Doctor doctor = new Doctor();
                    doctor.start();
                    Doctor++;
                  //  System.out.println("Doctor: "+Doctor);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Doctor--;
                   // System.out.println("Doctor: "+Doctor);
                }
            }

            if (random.nextBoolean()) {
                if (Visitor <= 4 && Doctor == 0 && Visitor>=0) {
                    Visitor visitor = new Visitor();
                    visitor.start();
                    Visitor++;
                  //  System.out.println("Visitor: "+Visitor);
                    try {
                      //  if(Visitor==3){Visitor=Visitor-3;}
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   // Visitor--;
                  //  System.out.println("Visitor: "+Visitor);
                }
            }
        }
        System.out.println("Doctor: "+Doctor);
        System.out.println("Visitor: "+Visitor);
    }
}

class Doctor extends Thread {
    @Override
    public void run() {
        try {
            sleep(200);        //Приостанавливает поток на 1 секунду
        } catch (InterruptedException e) {
        }

    }
}

class Visitor extends Thread {
    @Override
    public void run() {
        try {
            sleep(200);        //Приостанавливает поток на 1 секунду
        } catch (InterruptedException e) {
        }

    }
}
