package bai_hoc.xu_li_ngoai_le_va_de_debug.bai_tap.su_dung_lop_Illegal_triangle_exception;

class IllegalRightTriangleException extends Exception {
    String errorMessage;
    public IllegalRightTriangleException(String inErrorMessage) {
        this.errorMessage = inErrorMessage;
    }

    @Override
    public String toString() {
        return "IllegalRightTriangleException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}