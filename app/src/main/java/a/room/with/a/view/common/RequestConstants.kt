package a.room.with.a.view.common

import java.text.SimpleDateFormat
import java.util.*

object RequestConstants{
    val clientId = "FJIWSEVCA3FZ4E35PLZGUCRW1ZZJ1SJ1IB0OOFURZ4QF2NBT"
    val clientSecret = "GZ0LNZQGPJP1QOFGBAOQAIYHPMDEUWMLWX5LXCY2UYKYDMUS"
    val near = "Rotterdam"
    val radius = 1000
    val intent = "checkin"
    fun v(): String{
        val pattern = "yyyyMMdd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        return simpleDateFormat.format(Date())
    }
}