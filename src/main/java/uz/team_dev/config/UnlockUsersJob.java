//package uz.team_dev.config;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.TimerTask;
//
//    @Slf4j
//    public class UnlockUsersJob extends TimerTask {
//        @Override
//        public void run() {
//            log.info(" <= :: un clock users procedure called :: ");
//
//            try (Connection connection = HibernateJavaConfigurer.getSessionFactory()) {
//                CallableStatement callableStatement = connection.prepareCall("call sch_todo.unlock_users()");
//                     callableStatement.execute();
//                // TODO: 7/6/2022 call unlock procedure here every xyz minutes
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
