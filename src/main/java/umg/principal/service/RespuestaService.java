package umg.principal.service;

import umg.principal.dao.RespuestaDao;
import umg.principal.db.DatabaseConnection;
import umg.principal.db.TransactionManager;
import umg.principal.model.Respuesta;
import umg.principal.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RespuestaService {

    private RespuestaDao respuestaDao = new RespuestaDao();


    public void crearRespuesta(umg.principal.model.Respuesta respuesta) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                respuestaDao.insertarRespuesta(respuesta);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }

    }

    public void actualizarRespuesta(umg.principal.model.Respuesta respuesta) throws SQLException {
        respuestaDao.actualizarRespuesta(respuesta);
    }

    public umg.principal.model.Respuesta obtenerRespuestaPorId(int id) throws SQLException {
        return respuestaDao.getRespuestaPorId(id);
    }

    public umg.principal.model.Respuesta obtenerRespuestaPorSeccion(String seccion) throws SQLException {
        return respuestaDao.getRespuestaPorSeccion(seccion);
    }

    public umg.principal.model.Respuesta obtenerRespuestaPorTelegramId(long telegramId) throws SQLException {
        return respuestaDao.getRespuestaPorTelegramId(telegramId);
    }

    public umg.principal.model.Respuesta obtenerRespuestaPorFechaRespuesta(Timestamp fechaRespuesta) throws SQLException {
        return respuestaDao.getRespuestaPorFechaRespuesta(fechaRespuesta);
    }

}