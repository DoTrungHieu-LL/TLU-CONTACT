package com.tlu.contact.data;

import com.tlu.contact.model.Staff;
import com.tlu.contact.model.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to provide data for the application
 * In a real-world scenario, this would likely be fetched from a database or API
 */
public class ContactData {

    /**
     * Get list of university units
     */
    public static List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();

        units.add(new Unit(1, "Khoa Công nghệ thông tin",
                "024 3852 4529",
                "Tầng 2, Nhà C1, 175 Tây Sơn, Đống Đa, Hà Nội",
                "cse@tlu.edu.vn",
                "http://cse.tlu.edu.vn",
                "Khoa Công nghệ thông tin, trường Đại học Thủy Lợi"));

        units.add(new Unit(2, "Khoa Kinh tế và Quản lý",
                "024 3852 4372",
                "Tầng 4, Nhà A5, 175 Tây Sơn, Đống Đa, Hà Nội",
                "khoakiem@tlu.edu.vn",
                "http://fem.tlu.edu.vn",
                "Khoa Kinh tế và Quản lý, trường Đại học Thủy Lợi"));

        units.add(new Unit(3, "Khoa Kỹ thuật xây dựng",
                "024 3852 4271",
                "Tầng 2, Nhà A1, 175 Tây Sơn, Đống Đa, Hà Nội",
                "khoaxd@tlu.edu.vn",
                "http://ce.tlu.edu.vn",
                "Khoa Kỹ thuật xây dựng, trường Đại học Thủy Lợi"));

        units.add(new Unit(4, "Phòng Đào tạo",
                "024 3852 4529",
                "Tầng 1, Nhà A1, 175 Tây Sơn, Đống Đa, Hà Nội",
                "phonghcth@tlu.edu.vn",
                "http://tlu.edu.vn",
                "Phòng Đào tạo, trường Đại học Thủy Lợi"));

        units.add(new Unit(5, "Phòng Khoa học Công nghệ",
                "024 3563 3125",
                "Tầng 3, Nhà A1, 175 Tây Sơn, Đống Đa, Hà Nội",
                "khcn@tlu.edu.vn",
                "http://khcn.tlu.edu.vn",
                "Phòng Khoa học Công nghệ, trường Đại học Thủy Lợi"));

        units.add(new Unit(6, "Thư viện",
                "024 3852 4687",
                "Nhà C5, 175 Tây Sơn, Đống Đa, Hà Nội",
                "thuvien@tlu.edu.vn",
                "http://thuvien.tlu.edu.vn",
                "Thư viện, trường Đại học Thủy Lợi"));

        return units;
    }

    /**
     * Get a specific unit by ID
     */
    public static Unit getUnitById(long id) {
        List<Unit> units = getUnits();
        for (Unit unit : units) {
            if (unit.getId() == id) {
                return unit;
            }
        }
        return null;
    }

    /**
     * Get list of staff members
     */
    public static List<Staff> getStaffList() {
        List<Staff> staffList = new ArrayList<>();

        staffList.add(new Staff(1, "PGS.TS. Nguyễn Thanh Tùng",
                "Trưởng khoa",
                "024 3852 4536",
                "tungnt@tlu.edu.vn",
                "Khoa Công nghệ thông tin",
                "P205, Nhà C1",
                ""));

        staffList.add(new Staff(2, "TS. Đặng Thị Thu Hiền",
                "Phó Trưởng khoa",
                "024 3852 4537",
                "hiendt@tlu.edu.vn",
                "Khoa Công nghệ thông tin",
                "P204, Nhà C1",
                ""));

        staffList.add(new Staff(3, "TS. Nguyễn Hữu Quyền",
                "Trưởng Bộ môn Công nghệ phần mềm",
                "024 3852 4538",
                "quyennh@tlu.edu.vn",
                "Khoa Công nghệ thông tin",
                "P203, Nhà C1",
                ""));

        staffList.add(new Staff(4, "ThS. Nguyễn Thị Phương Thảo",
                "Giảng viên",
                "024 3852 4539",
                "thaontp@tlu.edu.vn",
                "Khoa Công nghệ thông tin",
                "P202, Nhà C1",
                ""));

        staffList.add(new Staff(5, "GS.TS. Trần Văn Hà",
                "Trưởng khoa",
                "024 3852 4540",
                "hatv@tlu.edu.vn",
                "Khoa Kinh tế và Quản lý",
                "P405, Nhà A5",
                ""));

        staffList.add(new Staff(6, "TS. Trần Thị Mai",
                "Phó Trưởng khoa",
                "024 3852 4541",
                "maitt@tlu.edu.vn",
                "Khoa Kinh tế và Quản lý",
                "P404, Nhà A5",
                ""));

        staffList.add(new Staff(7, "ThS. Nguyễn Văn Bắc",
                "Trưởng phòng",
                "024 3852 4542",
                "bacnv@tlu.edu.vn",
                "Phòng Đào tạo",
                "P102, Nhà A1",
                ""));

        staffList.add(new Staff(8, "TS. Lê Thị Hương",
                "Phó Trưởng phòng",
                "024 3852 4543",
                "huonglt@tlu.edu.vn",
                "Phòng Đào tạo",
                "P103, Nhà A1",
                ""));

        return staffList;
    }

    /**
     * Get a specific staff member by ID
     */
    public static Staff getStaffById(long id) {
        List<Staff> staffList = getStaffList();
        for (Staff staff : staffList) {
            if (staff.getId() == id) {
                return staff;
            }
        }
        return null;
    }
}
