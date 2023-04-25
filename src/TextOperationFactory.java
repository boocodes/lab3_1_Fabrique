public class TextOperationFactory {
    public ExternalInterface getOperation(FunctionType type){
        ExternalInterface madeOperation = null;
        switch (type){
            case UNIQUE:
                madeOperation = new InheritedClassTwo();
                break;
            case SAME:
                madeOperation = new InheritedClassOne();
                break;
            default:
                madeOperation = null;
                break;
        }
        return madeOperation;
    }
}
