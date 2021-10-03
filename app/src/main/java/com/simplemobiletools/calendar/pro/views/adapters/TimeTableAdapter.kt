//package com.simplemobiletools.calendar.pro.views.adapters
// import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.animation.AnimationUtils
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
// import com.simplemobiletools.calendar.pro.R
// import com.simplemobiletools.calendar.pro.model.ClassModel
//import com.squareup.picasso.Picasso
//import java.util
//
//
//
//
//
//class TimeTableAdapter(
//    courseList: ArrayList<ClassModel>,
//    context: Context,
//    listener: CourseClickInterface
//) :
//    RecyclerView.Adapter<TimeTableAdapter.ViewHolder>() {
//     private val courseList: ArrayList<ClassModel> = courseList
//    private val context: Context = context
//    private val courseClickInterface: CourseClickInterface = courseClickInterface
//    var lastPos = -1
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//         val view: View =
//            LayoutInflater.from(context).inflate(R.layout.course_rv_item, parent, false)
//        return ViewHolder(view)
//    }
//
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // setting data to our recycler view item on below line.
//        val course: ClassModel = courseList[position]
//        holder.courseTV.setText(course.courseName)
//        holder.coursePriceTV.text = "Rs. " + course.courseDescription
//        Picasso.get().load(course.getCourseImg()).into(holder.courseIV)
//        // adding animation to recycler view item on below line.
//        setAnimation(holder.itemView, position)
//        holder.courseIV.setOnClickListener { courseClickInterface.onCourseClick(position) }
//    }
//
//    private fun setAnimation(itemView: View, position: Int) {
//        if (position > lastPos) {
//            // on below line we are setting animation.
//            val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
//            itemView.animation = animation
//            lastPos = position
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return courseList.size
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        // creating variable for our image view and text view on below line.
//        private val imCourse: ImageView = itemView.findViewById(R.id.iv_course)
//        private val tvCourseName: TextView = itemView.findViewById(R.id.tv_course_name)
//        private val tvVenue: TextView = itemView.findViewById(R.id.tv_venue)
//
//    }
//
//    // creating a interface for on click
//    interface CourseClickInterface {
//        fun onCourseClick(position: Int)
//    }
//
//}
