
package com.taxitabby.DOK

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class AdapterOfTargetTheHacked(private val DataSet : Array<String>) :
RecyclerView.Adapter<AdapterOfTargetTheHacked.ViewHolder>(){


    // 뷰 홀더는 어디에 그릴껀지 정하는 놈
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        public val textType : TextView
        public val textNumber : TextView
        public val textHash : TextView

        init {
            // Define click listener for the ViewHolder's View.
            textType = view.findViewById(R.id.hacked_row_of_bluetooth_near__field_of_type)
            textNumber = view.findViewById(R.id.hacked_row_of_bluetooth_near__field_of_number)
            textHash = view.findViewById(R.id.hacked_row_of_bluetooth_near__field_of_hash)
        }
    }

    //홀더에 접근해서 값을 대입해주는 놈
    override fun onBindViewHolder(holder: AdapterOfTargetTheHacked.ViewHolder, position: Int) {
        holder.textType.text = DataSet[position]
        holder.textNumber.text = DataSet[position]
        holder.textHash.text = DataSet[position]

        val layoutParam = holder.itemView.layoutParams
        layoutParam.height = 120
        holder.itemView.requestLayout()

    }

    //xml인 레이아웃을 사용가능한 뷰로 만들고 그걸 반환하는 놈
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hacked_row_of_bluetooth_near, parent, false)
        return ViewHolder(view)
    }

    //기냥 내부에서 쓰려고 필요한 놈
    override fun getItemCount(): Int {
        return DataSet.size
    }


}