package leetcode_8_9;

import define.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    /**
     *
     * 可以使用插入排序， 作用头节点
     *
     * 每次取顺序取头结点， 插入该头结点的next
     *
     * over
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {



        ListNode dummyHead = new ListNode(-1);

        ListNode currentNode = dummyHead;

        List<ListNode> nodeList = new LinkedList<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null) nodeList.add(lists[i]);
        }

        Collections.sort(nodeList, Comparator.comparingInt(l -> l.val));

        while(!nodeList.isEmpty()) {
            ListNode selectNode = nodeList.remove(0);
            currentNode.next = selectNode;
            currentNode = currentNode.next;

            ListNode insertNode = selectNode.next;

            //插入insertNode
            if (insertNode==null) continue;
            int i = 0;
            for (;i < nodeList.size(); i++) {
                if (insertNode.val < nodeList.get(i).val) {
                    nodeList.add(i, insertNode);
                    break;
                }
            }
            if (i == nodeList.size()) nodeList.add(i, insertNode);
        }
        return dummyHead.next;
    }
}
