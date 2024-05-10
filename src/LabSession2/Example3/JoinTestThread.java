package LabSession2.Example3;
class JoinTestThread extends Thread{
    Thread t;

    private int number;
    private int sum;
    JoinTestThread(String n, Thread t,int number){
        this.setName(n);
        this.t=t;
        this.number = number;
    }
    public void run() {
        System.out.println("Thread "+this.getName()+" has entered the run() method for number:"+this.number);
        try {

            if (t != null) t.join();
            System.out.println("Thread "+this.getName()+" executing Divisor find.");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) { // Verificăm dacă i este divizor
                    sum += i; // Adăugăm divizorul la sumă
                }
            }


        }
        catch(Exception e){e.printStackTrace();}
        System.out.println("Sum: "+this.sum);
        System.out.println("Thread "+this.getName()+" has terminated operation.");
    }
}
