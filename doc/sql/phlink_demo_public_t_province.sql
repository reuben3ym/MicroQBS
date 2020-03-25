create table t_province
(
  "_id"       integer not null
    constraint t_province_pkey
      primary key,
  name        varchar(64),
  province_id varchar(12)
);

alter table t_province
  owner to postgres;

INSERT INTO public.t_province (_id, name, province_id) VALUES (1, '北京市', '110000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (2, '天津市', '120000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (3, '河北省', '130000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (4, '山西省', '140000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (5, '内蒙古自治区', '150000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (6, '辽宁省', '210000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (7, '吉林省', '220000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (8, '黑龙江省', '230000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (9, '上海市', '310000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (10, '江苏省', '320000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (11, '浙江省', '330000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (12, '安徽省', '340000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (13, '福建省', '350000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (14, '江西省', '360000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (15, '山东省', '370000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (16, '河南省', '410000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (17, '湖北省', '420000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (18, '湖南省', '430000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (19, '广东省', '440000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (20, '广西壮族自治区', '450000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (21, '海南省', '460000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (22, '重庆市', '500000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (23, '四川省', '510000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (24, '贵州省', '520000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (25, '云南省', '530000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (26, '西藏自治区', '540000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (27, '陕西省', '610000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (28, '甘肃省', '620000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (29, '青海省', '630000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (30, '宁夏回族自治区', '640000000000');
INSERT INTO public.t_province (_id, name, province_id) VALUES (31, '新疆维吾尔自治区', '650000000000');