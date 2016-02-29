package next.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;

@WebServlet("/qna/show")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long questionId = Long.parseLong(req.getParameter("questionId"));
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		req.setAttribute("question", questionDao.findById(questionId));
		req.setAttribute("answers", answerDao.findAllByQuestionId(questionId));

		RequestDispatcher rd = req.getRequestDispatcher("/qna/show.jsp");
		rd.forward(req, resp);
	}
}