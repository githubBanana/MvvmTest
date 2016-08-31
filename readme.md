Mvvm And Mvp 框架
===============

当 android:text="`@{myviewmodel.a}`" 时： getViewModel().a.set("hehehe") 有效，【可在view层或model操作】<br>
当 android:text="";时：getBinding().tvA.setText("hehehe")有效【可在activity等view层操作UI】<br>

refer to :<br>
 http://rocko.xyz/2015/11/07/MVVM_Android-CleanArchitecture/#more
 
    【
    在activity等UI上，将viewmodel当做presenter，而在viewmodel上，可将其认为view等UI，然后新建presenter类biz，将
    activity要调用的方法放在其viewmodel，再次放到其presenter类biz去实现；
    viewmodel根据父类getcallback方法，将数据反馈到activity，即P->V；biz根据父类getView方法，将数据反馈到viewmodel，
    也是P->V模式。
    这里的MVP中的M没什么体现，主要是把网络、数据处理等工具放到了各父基类中。
    】
 

另外
===
gradle统一管理编译

