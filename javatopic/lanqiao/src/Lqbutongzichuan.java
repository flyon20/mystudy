/*
* 一个字符串的非空子串是指字符串中长度至少为 11 的连续的一段字符组成的串。例如，字符串 aaabaaab
* 有非空子串 a, b, aa, ab, aaa, aab, aaaba,b,aa,ab,aaa,aab,aaab，一共 77 个。
注意在计算时，只算本质不同的串的个数。
请问，字符串 01001100010100010100110001010001 有多少个不同的非空子串？*/
import java.util.HashSet;
import java.util.Set;

public class Lqbutongzichuan {
	/*Set的实现类有三个
	 *  HashSet类按照哈希算法来存取集合中的对象，存取速度比较快。
         1.Set中是不能出现重复数据的。
         2.Set中可以出现空数据。
         3.Set中的数据是无序的。
         LinkedHashSet类
               这个相对于HashSet来说有一个很大的不一样是LinkedHashSet是有序的。
        LinkedHashSet在迭代访问Set中的全部元素时，
               性能比HashSet好，但是插入时性能稍微逊色于HashSet。
       TreeSet类：
       	 1.不能写入空数据
       	 2.写入的数据是有序的
       	 3.不写入重复数据
	 */
    /*解题思路：
     * 从第一个字符开始，每个字符都是一个子串，
     * 每个子串的长度从1开始然后是2，3.......
     * 直到子串长度为原字符串长度为止
     */

    public static void main(String[] args) {
        String str="0100110001010001";
		/*
		 * 使用set集合创建一个字符串集合，存储子串，
		 * 则字符串集合的长度即为不同子串的个数
		 （因为set集合中不会出现重复数据）
		 */
        Set<String> set=new HashSet<String>();
        for(int count=0;count<str.length();count++){
            for(int beginindex=0,endindex=1+count;endindex<=str.length();beginindex++,endindex++) {
                set.add(str.substring(beginindex,endindex));
                /*set集合中所用的方法
                 * .add()方法：
                 *作用：向集合中添加数据；且Set集合不能存储重复的数据
                 *格式：对象名.add（添加内容）；（添加内容必须与对象的类型一致）
                 *.size()方法：
                 * 作用：统计集合中有多少元素（元素可以重复储存）
                 *格式：对象名.size()；
                 *substring()String substring(int beginIndex, int endIndex)，
                 *返回String下标从beginIndex到下标endIndex-1之间的字符串。
                 */
                System.out.println(str.substring(beginindex,endindex));
            }
        }
        System.out.println(set.size());
    }
}


