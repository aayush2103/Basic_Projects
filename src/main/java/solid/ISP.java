package solid;


// Interface Segregation Principle
//      recommendation on how to split interfaces into smaller interfaces
public class ISP {
    public static void main(String[] args) {
        /* 1. here we implement a general interface doing all the operations
        *     For new model printers implementing above interface, all 3 methods can be implemented
        *     but for old model printers, methods scan and fax will not be used/implemented
        *     and here comes the ISP */

        /* 2. here we separate the interfaces according to ISP so that respective classes can
        *     only implement required/meaningful methods to them*/
    }
}


class Document {}

// 1.
interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {
        // body
    }

    @Override
    public void fax(Document d) {
        // body
    }

    @Override
    public void scan(Document d) {
        // body
    }
}
class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {
        // body
    }

    @Override
    public void fax(Document d) {
        // not required
    }

    @Override
    public void scan(Document d) {
        // not required
    }
}

//2.
interface Printer {
    void print(Document d);
}
interface Scanner {
    void scan(Document d);
}

class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {
        // body
    }
}

class PhotoCopier implements Printer, Scanner {

    @Override
    public void print(Document d) {
        // body
    }

    @Override
    public void scan(Document d) {
        // body
    }
}
