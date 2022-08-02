package demo.StaticInitialization_;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/13 09:42
 */
public class StaticInitialization {
    public static void main(String args[]) {
        System.out.println("main()");
        cupboard.otherMethod(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
}

class Tableware {
    static Bowl bowl7 = new Bowl(7);

    static {
        System.out.println("Tableware静态代码块");
    }

    Tableware() {
        System.out.println("Tableware构造方法");
    }

    Bowl bowl6 = new Bowl(6);
}

class Table extends Tableware {
    {
        System.out.println("Table非静态代码块_1");
    }

    Bowl bowl5 = new Bowl(5);    // 9

    {
        System.out.println("Table非静态代码块_2");
    }

    static Bowl bowl1 = new Bowl(1);

    static {
        System.out.println("Table静态代码块");
    }

    Table() {
        System.out.println("Table构造方法");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard extends Tableware {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard构造方法");
    }

    void otherMethod(int marker) {
        System.out.println("otherMethod(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

/**
 * 输出顺序：
 * 1、Bowl(7)
 * 2、Tableware静态代码块
 * 3、Bowl(1)
 * 4、Table静态代码块
 * 5、Bowl(2)
 * 6、Bowl(6)
 * 7、Tableware构造方法
 * 8、Table非静态代码块_1
 * 9、Bowl(5)
 * 10、Table非静态代码块_2
 * 11、Table构造方法
 * 12、Bowl(4)
 * 13、Bowl(5)
 * 14、Bowl(6)
 * 15、Tableware构造方法
 * 16、Bowl(3)
 * 17、Cupboard构造方法
 * 18、main()
 * 19、otherMethod(1)
 */
