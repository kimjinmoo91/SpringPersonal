package com.sparta.week01.prac;

public class Course {
        // title, tutor, days 가 Course 라는 맥락 아래에서 의도가 분명히 드러나죠!
        public String title;
        public String tutor;
        public int days;

        public Course() {
// 아무것도 없고 괄호만 있는 것을 '기본 생성자', '메서드는 항상 public 써야함, 클래스명과 똑같게'
        }
        public Course(String title, String tutor, int days) {
//생성자를 넣어주면 생성자를 없는 것으로 취급 하기 때문에 기본 생성자를 넣어줘야한다.
                this.title = title;
                this.tutor = tutor;
                this.days = days;
        }

        public void setTitle (String title) {
                this.title = title;
        }

        public void setTutor(String tutor) {
                this.tutor = tutor;
        }

        public void setDays(int days) {
                this.days = days;
        }
        public String getTitle() {
                return this.title;
        }
        public String getTutor() {
                return this.tutor;
        }
        public int getDays () {
                return this.days;
        }

    }