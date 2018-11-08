//有错，回头改
//改好了
/**
 思路：罗马数字“AB”，如果A<B，则表示值为B-A; A>B，表现值为A+B
 那么干脆一个一个字符地读，如果当前字符的值大于前一个字符的值就表示前一个字符表示的是剪去它的意思
 由于之前读到前一个字符的时候已经加了它的值，现在需要减两倍
**/
    public int romanToInt(String s){
        if(s==null) return 0;

        int prev = getValue(s.charAt(0));
        int res = prev;

        for(int i = 1; i<s.length(); i++){
            int cur = getValue(s.charAt(i));
            res += cur > prev ? cur - 2*prev : cur;
            //忘了加这一句
            prev = cur;
        }
        return res;

    }

    public int getValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
