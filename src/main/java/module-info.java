module com.nulp.course_work {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires java.sql;


    opens com.nulp.course_work to javafx.fxml;
    exports com.nulp.course_work;
}