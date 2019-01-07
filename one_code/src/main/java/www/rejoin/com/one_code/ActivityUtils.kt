package www.rejoin.com.one_code

import android.app.Activity

/**
 * Created by Administrator on 2018/12/28.
 */
class ActivityUtils {
    companion object {
        var arrayList = ArrayList<Activity>()
        fun addActivity(activity: Activity) {
            arrayList.add(activity)

        }

        fun removeActivity(activity: Activity) {
            arrayList.remove(activity)
        }

        fun finishAll() {
            for (item in arrayList) {
                item.finish()
            }
        }
    }
}