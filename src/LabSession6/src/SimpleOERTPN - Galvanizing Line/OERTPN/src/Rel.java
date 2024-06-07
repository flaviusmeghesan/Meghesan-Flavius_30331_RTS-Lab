public class Rel {
    Integer r,e,l;

    public Rel(Integer r, Integer e, Integer l) {
        this.r = r;
        this.e = e;
        this.l = l;
    }

    public Integer getR() {
        return r;
    }

    public Integer getE() {
        return e;
    }

    public Integer getL() {
        return l;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public void setL(Integer l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "Rel{" +
                "r=" + r +
                ", e=" + e +
                ", l=" + l +
                '}';
    }
}
