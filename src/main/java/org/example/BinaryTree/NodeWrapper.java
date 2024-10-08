package org.example.BinaryTree;

class NodeWrapper{
    int value;
    int row;
    int column;
    NodeWrapper(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "NodeWrapper{" +
                "value=" + value +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
