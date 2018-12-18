/*
 题目要求：Given an absolute path for a file (Unix-style), simplify it.
 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 path = "/a/../../b/../c//.//", => "/c"
 path = "/a//b////c/d//././/..", => "/a/b/c"
 
 以下是我根据python的一个最佳算法得出的改过来的，很容易懂，也很快，和我一开始想的一样
 用栈来存储对象，有".."就pop
 时间复杂度: O(n)
 空间复杂度: O(n)
 */
class Solution {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		String[] temp = path.split("/");
		for(String p : temp){
			if(p.length()==0)
				continue;
			//String用equals函数与字符串比对
			if(p.equals("."))
				continue;
			else if(p.equals("..")){
				if(s.size()!=0)
					s.pop();
			}else{
					//System.out.println("bbb");
				s.push(p);
			}
		}
			//System.out.println(s.size());
		StringBuilder sb = new StringBuilder();
		//如果是空的需要返回"/"
		if(s.empty())
			sb.insert(0,"/");
		while(!s.empty()){
			sb.insert(0,s.pop());
			sb.insert(0,"/");
		}
		
		return sb.toString();
	}
}

//这是那个python的代码，缩进被消除了
class Solution:
def simplifyPath(self, path):
"""
:type path: str
:rtype: str
"""
stack = []
path = path.split('/')
for p in path:
if len(p) == 0:
continue

if p == '.':
continue
elif p == '..':
if len(stack) != 0:
stack.pop(-1)
else:
stack.append(p)
return '/' + '/'.join(stack)
