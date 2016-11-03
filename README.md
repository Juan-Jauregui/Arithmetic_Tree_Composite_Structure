# Arithmetic_Tree_Composite_Structure
An exercise in OOP Design Patterns: Uses a LinkedList-based Component/Composite structure to represent arithmetic expressions as trees. Uses the Visitor pattern to externalize different ways of expressing the tree structure (infix, evaluated, &amp;c).


    ┌────────────────────────────┐     ┌───────────────────────────────┐    ┌──────────────────┐ 
    │          {Abstract}        │     │       ComponentIterator       │    │ <<interface>>    │ 
    │          Component         │  ┌─>│ (Implements Iter <Component>) ├ ─ ▷│    Iter<T>       │ 
    ├────────────────────────────┤  │  ├───────────────────────────────┤    ├──────────────────┤ 
    │+parent:Component=null      │  │  │#composite:Component           │    │+first(): void    │ 
    │-numChildren:int=0          │  │  │#current:Component             │    │+next(): void     │ 
    │                            │  │  │                               │    │                  │ 
    │+Component()                │  │  │+ComponentIterator(c:Component)│    │+currentItem():T  │ 
    │                            │  │  │                               │    │                  │ 
    │#setParent(p:Component):void│  │  │+first(): void                 │    │+isDone():boolean │ 
    │+getParent():Component      │  │  │+next(): void                  │    └──────────────────┘ 
    │+add(c:Component):void      │  │  │+currentItem():Component       │                         
    │+remove(c:Component):void   │  │  │+isDone():boolean              │                         
    │+doAdd(c:Component):void    │  │  └───────────────────────────────┘                         
    │+doRemove(c:Component):void │  │                         △                                  
    │+makeIter():Iter<Component> │<─┘                         │                                  
    │+getNumChildren():int       │                            │                                  
    └────────────────────────────┘                            │                                  
                      △                        ┌──────────────┴──────────────────────────────┐   
                      │                        │           LinkedCompositeIterator           │   
    ┌─────────────────┴─────────────────┐      ├─────────────────────────────────────────────┤   
    │          LinkedComposite          │      │ -curNode:Node<Component>                    │   
    ├───────────────────────────────────┤      │                                             │   
    │-root:Node<Component>=null         │      │ +LinkedCompositeIterator(lc:LinkedComposite)│   
    │                                   │      │                                             │   
    │+makeIter():LinkedCompositeIterator│<────>│ +first(): void                              │   
    │                                   │      │ +next(): void                               │   
    │+doAdd():void                      │      │                                             │   
    │+doRemove():void                   │      │ +currentItem():T                            │   
    │                                   │      │                                             │   
    │+getRootNode():Node<Component>     │      │ +isDone():boolean                           │   
    └───────────────────────────────────┘      └─────────────────────────────────────────────┘   
                      △                                                                          
                      └──────────────────────────────┐                                           
                                                     │                                           
                              ┌──────────────────────┴──────────────────┐                        
                              │                 {Abstract}              │                        
                              │             ArithmeticComponent         │                        
                              ├─────────────────────────────────────────┤                        
                              │+ArithmeticComponent(comps...: Component)│                        
                              │+letTheRightOneIn(v: Visitor):String     │                        
                              └─────────────────────────────────────────┘                        
                                                  △                                              
                                                  │                                              
                                                  │                                              
                     ┌────────────────────────────┤                                              
                     │                            │                                              
    ┌────────────────┴──────────────────┐         │        ┌───────────────────────────────────┐ 
    │          NumberComponent          │         ├────────┤           PlusComponent           │ 
    ├───────────────────────────────────┤         │        ├───────────────────────────────────┤ 
    │-Value:double                      │         │        │+PlusComponent(val:double)         │ 
    │                                   │         │        │                                   │ 
    │+NumberComponent(val:double)       │         │        │+letTheRightOneIn(v:Visitor):String│ 
    │                                   │         │        │                                   │ 
    │+letTheRightOneIn(v:Visitor):String│         │        │+toString():String                 │ 
    │                                   │         │        └───────────────────────────────────┘ 
    │+getValue():double                 │         │        ┌───────────────────────────────────┐ 
    │                                   │         ├────────┤          MinusComponent           │ 
    │+add(c:Component):void             │         │        ├───────────────────────────────────┤ 
    │+remove(c:Component):void          │         │        │+MinusComponent(val:double)        │ 
    │                                   │         │        │                                   │ 
    │+toString():String                 │         │        │+letTheRightOneIn(v:Visitor):String│ 
    └───────────────────────────────────┘         │        │                                   │ 
                                                  │        │+toString():String                 │ 
                                                  │        └───────────────────────────────────┘ 
    ┌───────────────────────────────────┐         │        ┌───────────────────────────────────┐ 
    │          TimesComponent           ├─────────┴────────┤          DivideComponent          │ 
    ├───────────────────────────────────┤                  ├───────────────────────────────────┤ 
    │+TimesComponent(val:double)        │                  │+DivideComponent(val:double)       │ 
    │                                   │                  │                                   │ 
    │+letTheRightOneIn(v:Visitor):String│                  │+letTheRightOneIn(v:Visitor):String│ 
    │                                   │                  │                                   │ 
    │+toString():String                 │                  │+toString():String                 │ 
    └───────────────────────────────────┘                  └───────────────────────────────────┘ 
