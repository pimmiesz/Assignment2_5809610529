package com.example.patchariya.assignment2;

public class Stick {
    String[] good = {"ช่วงนี้จับอะไรก็เป็นเงินเป็นทอง","ช่วงนี้ชีวิตเหมาะกับการเริ่มต้นอะไรใหม่ๆ จะประสบความสำเร็จ","หมดทุกข์แล้ว ต่อจากนี้จะมีแต่ความสุขทำอะไรก็สำเร็จ","ดวงกำลังขึ้น ทำอะไรก้มีคนสนับสนุน"};
    String[] fair = {"ช่วงนี้ชีวิตธรรมดา ไม่มีอะไรหวือหวา","ชีวิตปกติ ไม่มีอะไรน่ากังวล","ใช้ชีวิตตามปกติ ไม่มีเรื่องแย่ๆเข้ามาช่วงนี้","สบายใจได้ช่วงนี้ไม่มีไรแย่"};
    String[] bad = {"ระวังประสบอุบัติเหตุ","เสียทรัพย์ก้อนโต","ช่วงนี้ไม่ควรลงทุนอะไร","ช่วงนี้ทำอะไรคิดดีๆ มีคนจ้องทำร้าย"};

    public String getStick(int index,int fate) {
        String answer=null;
        if(fate==0){
            answer=good[index];
        }
        else if (fate==1){
            answer=fair[index];
        }
        else{
            answer=bad[index];
        }
        return answer;
    }
}