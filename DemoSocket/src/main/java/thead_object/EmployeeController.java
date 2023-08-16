package thead_object;

import java.io.IOException;
import java.util.Objects;

public class EmployeeController extends Controller{
    @Override
    public String doGet(Request request, Response response) throws IOException {

        if (request.getAction().equals("employees")) {
            response.getObjectOutputStream().writeObject("SHOW HANG");
        }
        if (Objects.equals(request.getAction(), "menu")) {
            String menu = String.format("" +
                    "Menu chương trình \n" +
                    "Nhập 1. Xem danh sách \n" +
                    "Nhập 2. Thêm mới \n" +
                    "Nhập 3. Xóa"
            );
            response.setData(menu);
            response.getObjectOutputStream().writeObject(response);
        }

        response.setStatusCode("200");
        return null;
    }

    @Override
    public String doPost(Request request, Response response) throws IOException{
        if(Objects.equals(request.getAction(), "create")){
            System.out.println("REQUEST DATA: " + request.getData());
            response.setData("THÊM THÀNH CÔNG");
            response.setStatusCode("200");
            response.getObjectOutputStream().writeObject(response);
        }
        return null;
    }

    public EmployeeController(Request request, Response response) {
        this.request = request;
        this.response = response;
    }
}
