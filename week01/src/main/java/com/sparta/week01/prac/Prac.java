package com.sparta.week01.prac;

public class Prac {
    public static void main(String[] args) {
        // title, tutor, days 가 Course 라는 맥락 아래에서 의도가 분명히 드러나죠!

        course.title = "웹개발의 봄, Spring";
        course.tutor = "김진무";
        int days = 32;
        Course course = new Course();
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);
        System.out.println(course.title);
        System.out.println(course.tutor);


    }
}
