package tk.mybatis.sample.type;

//
public enum Enabled {
    // 枚举项的索引从0开始
    disabled(0), // 禁用 索引为 0
    enable(1);  // 启用 索引为 1

    private int value ;

    private Enabled(int value) {
        this.value = value;
    }


    public int getValue(){
        return this.value;
    }
}
