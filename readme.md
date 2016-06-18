

当 android:text="@{myviewmodel.a}" 时： getViewModel().a.set("hehehe") 有效，【可在view层或model操作】
当 android:text="";时：getBinding().tvA.setText("hehehe")有效【可在activity等view层操作UI】
