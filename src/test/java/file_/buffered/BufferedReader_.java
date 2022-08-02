package file_.buffered;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 10:39
 */
public class BufferedReader_ extends Reader_{
    private Reader_ reader;

    public BufferedReader_(Reader_ reader_){
        this.reader = reader_;
    }

    public void read(int num){
        for (int i = 0; i < num; i++) {
            reader.read();
        }
    }

    @Override
    public void read() {
        reader.read();
    }
}
