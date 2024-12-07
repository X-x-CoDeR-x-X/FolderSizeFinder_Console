public class NewThread extends Thread {
    private int threadNumber;
    public NewThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        for(;;){
            System.out.println(this.threadNumber);
        }
    }
}
