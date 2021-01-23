package ru.fom.myapplessons.ui.objects


import android.app.Dialog
import android.os.AsyncTask
import ru.fom.myapplessons.MainActivity
import ru.fom.myapplessons.R

class ProgressTask(var activity: MainActivity): AsyncTask<Any, Int, Any?>() {

    private val dialog = Dialog(activity)

    override fun onPreExecute() {
        val view = activity.layoutInflater.inflate(R.layout.progress_bar, null)
        dialog.setContentView(view)
        dialog.setCancelable(false)
        dialog.show()
        super.onPreExecute()
    }
    override fun doInBackground(vararg params: Any?): Any? {
        Thread.sleep(5000)
        return null
    }

    override fun onPostExecute(result: Any?) {
        super.onPostExecute(result)
        dialog.dismiss()
    }
}