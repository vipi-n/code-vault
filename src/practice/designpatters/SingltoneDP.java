package practice.designpatters;

class SingltonDP {

    //Eager initialization
    private static SingltonDP singltoneDP = new SingltonDP();
    private SingltonDP(){

    }
    public static SingltonDP  getInstance(){
        return singltoneDP;
    }

}

class SingltonDPLazy {

    //Lazy initialization
    private static SingltonDPLazy singltoneDP;
    private SingltonDPLazy(){

    }
    public static SingltonDPLazy  getInstance(){
        if (singltoneDP == null) {
            singltoneDP = new SingltonDPLazy();
        }
        return singltoneDP;
    }

}
//using synchronized method
class SynchronizedSingleton{

    private static SynchronizedSingleton instance;
    private SynchronizedSingleton(){

    }
    public static synchronized SynchronizedSingleton  getInstance(){
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
//using synchronized block

class SynchronizedSingleton1{

    private static SynchronizedSingleton1 instance;
    private SynchronizedSingleton1(){

    }
    public static synchronized SynchronizedSingleton1  getInstance(){
        if (instance == null) {
            synchronized (SynchronizedSingleton1.class){
                if (instance == null){
                    instance = new SynchronizedSingleton1();
                }
            }
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args) {
        SingltonDPLazy singltoneDPLazy = SingltonDPLazy.getInstance();
        System.out.println(singltoneDPLazy.hashCode());
        SingltonDPLazy singltoneDPLazy1 = SingltonDPLazy.getInstance();
        System.out.println(singltoneDPLazy1.hashCode());
    }
}

