package jvm;

public class Singleton4 {

    public Singleton4() {
    }

    private Singleton4 getinstance() {
        return Singleon.SINGLEON_SINGLE.getinstance();
    }


    private enum Singleon {
        SINGLEON_SINGLE;

        private Singleton4 singleton4;

        Singleon() {
            singleton4 = new Singleton4();
        }

        public Singleton4 getinstance() {
            return singleton4;
        }
    }
}
